<!doctype html>
<html>
<head>

    <meta name="layout" content="main"/>
    <title>Cadastro de Banda</title>
    <g:javascript library="jquery" />

    <script type="text/javascript">
        //    function carregarLista() {
        %{--<g:remoteFunction controller="produto" action="lista" update="divLista" onSuccess="carregarLista()" />--}%
        //    }

        function excluir(id) {
            if (confirm("Deseja realmente excluir?")){
                <g:remoteFunction controller="adicionarBanda" action="excluir" update="divLista" id="'+id+'" onSuccess="carregarLista()"/>
            }
        }

        function cancelar() {
            //Em vez de usar um Jquery, deve-se usar um $
            $("#divForm").html("")
        }
    </script>
</head>
<body>
<g:remoteLink controller="adicionarBanda" action="adicionar" update="divForm">Adicionar</g:remoteLink>
<a href="/adicionaLocal/index">Cadastrar Local</a>
<a href="/adicionaData/index">Cadastrar Show</a>



<div id="divLista">
    <g:render template="lista" model="[bandas: bandas]"></g:render>
</div>


<div id="divForm"></div>
</body>
</html>
