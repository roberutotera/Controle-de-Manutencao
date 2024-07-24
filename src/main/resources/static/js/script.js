const listasEndpoint = "http://localhost:8080/api/v1/manutencoes/lists";
console.log("testttt")
function hideLoader() {
	document.getElementById("loading").style.display = "none";
}

function show(manutencaos) {
	let table = `
		<thead>
			<tr>
				<th>Técnico</th>
				<th>Chamado</th>
				<th>Data</th>
				<th>Nome do Micro</th>
				<th>Fabricante</th>
				<th>Modelo</th>
				<th>Service Tag</th>
				<th>Unidade</th>
				<th>Setor</th>
				<th>Data da Manutenção Anterior</th>
				<th>Data da Próxima Manutenção</th>
				<th>Status</th>
				<th>Estado</th>
			</tr>
		</thead>
		<tbody>`;

	for (let manutencao of manutencaos) {
		table += `
			<tr>
				<td>${manutencao.tecnico.nome}</td>
				<td>${manutencao.chamado}</td>
				<td>${manutencao.data_manutencao}</td>
				<td>${manutencao.computador.nome_computador}</td>
				<td>${manutencao.computador.fabricante}</td>
				<td>${manutencao.computador.modelo}</td>
				<td>${manutencao.computador.service_tag}</td>
				<td>${manutencao.computador.unidade}</td>
				<td>${manutencao.computador.setor}</td>
				<td>${manutencao.data_manutencao_anterior}</td>
				<td>${manutencao.data_manutencao_proxima}</td>
				<td>${manutencao.status_manutencao}</td>
				<td>${manutencao.computador.estado}</td>
			</tr>`;
	}

	table += `</tbody>`;

	document.getElementById("manutencaoTable").innerHTML = table;
}

async function fetchManutencoes() {
	const token = localStorage.getItem("tokenJWT");

	if (!token) {
		window.location.href = "/view/login.html"; // Redireciona para o login se o token não estiver presente
		return;
	}

	try {
		const response = await fetch(listasEndpoint, {
			headers: {
				'Content-Type': 'application/json',
				'Authorization': `Bearer ${token}`
			},
		});

		if (response.ok) {
			const data = await response.json();
			console.log(data);
			hideLoader();
			show(data);
		} else {
			console.error("Erro ao buscar manutenções:", response.status);
			// Tratar erro aqui, como exibir uma mensagem ao usuário
		}
	} catch (error) {
		console.error("Erro inesperado:", error);
		// Tratar erro aqui, como exibir uma mensagem ao usuário
	}
}

document.addEventListener("load", function(event) {
	console.log("asdasdasdasdasd")
	fetchManutencoes();
});
