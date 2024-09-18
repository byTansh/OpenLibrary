function listarConteudo() {
  fetch('http://localhost:8080/conteudo').
  then(function(response){
    response.json().then(function(dados){
    let corpoDaTabela = document.getElementById('listagemPost')
    corpoDaTabela.innerHTML ='';
    dados.forEach(function(conteudo){
      let linha = document.createElement('post')
      let conteudoLinha = `
                <div  class="post">
                    <div class="post-header">
                      <img src="..//img/Logo.png" alt="User" class="user-avatar">
                      <div class="user-info">
                        <strong class="nomeUsuario">${conteudo.usuario}</strong>
                        <span>@${conteudo.usuario}</span>
                      </div>
                    </div>
                    <img src="${conteudo.imagem}" alt="Post" class="post-image">
                    <div class="post-actions">
                      <button class="download-button">Download</button>
                    </div>
                    <div class="post-content">
                      <p class="descricao"><strong>${conteudo.titulo}:</strong> ${conteudo.descricao}</p>
                      <span class="post-date">${conteudo.lancamento}</span>
                    </div>
                  </div>
                  <div>
                `
       linha.innerHTML = conteudoLinha;
       corpoDaTabela.appendChild(linha);
    })
  })
  })
}