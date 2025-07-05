const tbody = document.querySelector('#tabla-acts tbody');

fetch('/api/actividades/terminadas')
  .then(r => r.json())
  .then(acts => acts.forEach(a => tbody.appendChild(row(a))));

function row(a) {
  const tr = document.createElement('tr');
  tr.innerHTML = `
    <td>${a.id}</td>
    <td>${fmt(a.fechaInicio)}</td>
    <td>${a.sector}</td>
    <td>${a.nombre}</td>
    <td>${a.tema}</td>
    <td class="nota">${a.promedio ?? '-'}</td>
    <td><button data-id="${a.id}">Evaluar</button></td>`;
  tr.querySelector('button').onclick = evaluar;
  return tr;
}

function evaluar(e) {
  const id = e.target.dataset.id;
  const n  = +prompt('Ingresa nota (1–7):');
  if (!(n>=1 && n<=7)) return alert('Fuera de rango');

  fetch(`/api/actividades/${id}/notas`, {
    method:'POST',
    headers:{'Content-Type':'application/json'},
    body: JSON.stringify(n)
  })
  .then(r => r.json())
  .then(prom => e.target.closest('tr')
                       .querySelector('.nota').textContent = prom.toFixed(2))
  .catch(console.error);
}

const fmt = iso => iso ? new Date(iso).toLocaleDateString() : '';
