document.getElementById('notifyButton').addEventListener('click', function() {
    var container = document.getElementById('notificationContainer');
    container.innerHTML = `
      <div class="notification">
        <strong>¡Nuevo incidente en tu zona!</strong>
        <p>Servicio involucrado: Baños de la estación Medrano del Subte B</p>
        <p>Observaciones: Un borracho rompió la mochila del baño de hombres!</p>
        <button onclick="closeNotification()">Sí</button>
        <button onclick="closeNotification()">No</button>
      </div>
    `;
    container.classList.remove('hidden');
  });
  
  function closeNotification() {
    var container = document.getElementById('notificationContainer');
    container.classList.add('hidden');
  }