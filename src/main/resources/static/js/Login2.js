const form = document.getElementById("form");
const name = document.getElementById("name");
const password = document.getElementById("password");

form.addEventListener("submit", getData);

async function getData(e) {
  e.preventDefault();
  console.log({
    login: name.value,
    senha: password.value
  });
  try {
		let response = await fetch('http://localhost:8080/api/v1/auth/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ login: name.value, senha: password.value })
		});
   if (response.ok) {
			let data = await response.json();
			localStorage.setItem('tokenJWT', data.token);
		  	window.location.href = 'http://localhost:8080/project/listar-todas-manutencoes'; // Redirect to dashboard upon successful login
		}
} catch (e) {
    console.log(e);
  }
}
