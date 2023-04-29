document.getElementById('car-form').addEventListener('submit', async function(event) {
    event.preventDefault();
    const brand = document.getElementById('brand').value;
    const model = document.getElementById('model').value;
    const color = document.getElementById('color').value;
    const kilometers = document.getElementById('kilometers').value;

    const carRequest = {
        brand,
        model,
        color,
        kilometers: parseInt(kilometers, 10),
    };

    const response = await fetch('http://localhost:8080/api/car/addCar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(carRequest),
    });

    const carResponse = await response.json();
    alert('New car added: ' + JSON.stringify(carResponse));
    document.getElementById('car-form').reset();
});