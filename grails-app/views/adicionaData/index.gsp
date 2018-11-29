<!doctype html>
<html>
<head>

    <meta name="layout" content="main"/>
    <title>Cadastro de Datas</title>
    <g:javascript library="jquery" />

    <script type="text/javascript">
        //    function carregarLista() {
        %{--<g:remoteFunction controller="produto" action="lista" update="divLista" onSuccess="carregarLista()" />--}%
        //    }

        function excluir(id) {
            if (confirm("Deseja realmente excluir?")){
                <g:remoteFunction controller="adicionaData" action="excluir" update="divLista" id="'+id+'" onSuccess="carregarLista()"/>
            }
        }

        function cancelar() {
            $("#divForm").html("")
        }
    </script>
</head>
<body>
<g:remoteLink controller="adicionaData" action="adicionar" update="divForm">Adicionar</g:remoteLink>
<a href="/adicionarBanda/index">Cadastrar Bandas</a>
<a href="/adicionaLocal/index">Cadastrar Local</a>


<div id="divLista">
    <g:render template="lista" model="[shows: shows, bandas:bandas]"></g:render>

</div>


<div id="divForm"></div>
</body>
</html>
