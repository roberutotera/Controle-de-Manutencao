

document.getElementById('loginForm').addEventListener('submit', async function(event) {
	event.preventDefault();

	let username = document.getElementById('username').value;
	let password = document.getElementById('password').value;

	try {
		let response = await fetch('http://localhost:8080/api/v1/auth/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({ login: username, senha: password })
		});
		console.log(response)
		if (response.ok) {
			let data = await response.json();
			localStorage.setItem('tokenJWT', data.token);
			window.location.href = 'http://localhost:8080/project/listar-todas-manutencoes'; // Redirect to dashboard upon successful login
		} else {
			document.getElementById('message').innerText = 'Senha ou usuário incorreto, DIGITA CERTO CARAMBA!!!';
		}
	} catch (error) {
		console.error('Error:', error);
		document.getElementById('message').innerText = 'Algum erro ocorreu enquanto processou sua requisição.';
	}
});