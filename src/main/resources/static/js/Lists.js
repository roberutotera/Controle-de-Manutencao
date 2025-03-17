const listasEndpoint = 'http://localhost:8080/api/v1/manutencoes/lists';

async function fetchManutencoes() {
	const token = localStorage.getItem("tokenJWT");

	try {
	console.log(token)
		const response = await fetch(listasEndpoint, {
			headers: {
    				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
  		},
		});
			const data = await response.json()	
			return data;
		
	} catch (error) {
		console.error("Erro inesperado:", error);
		// Tratar erro aqui, como exibir uma mensagem ao usuário
	}
}

document.addEventListener("DOMContentLoaded",	fetchManutencoes);
