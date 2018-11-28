<!doctype html>
<html>
<head>

    <meta name="layout" content="main"/>
    <title>Cadastro de Locais</title>
    <g:javascript library="jquery" />

    <script type="text/javascript">
        //    function carregarLista() {
        %{--<g:remoteFunction controller="produto" action="lista" update="divLista" onSuccess="carregarLista()" />--}%
        //    }

        function excluir(id) {
            if (confirm("Deseja realmente excluir?")){
                <g:remoteFunction controller="adicionaLocal" action="excluir" update="divLista" id="'+id+'" onSuccess="carregarLista()"/>
            }
        }

        function cancelar() {
            //Em vez de usar um Jquery, deve-se usar um $
            $("#divForm").html("")
        }
    </script>
</head>
<body>
<g:remoteLink controller="adicionaLocal" action="adicionar" update="divForm">Adicionar</g:remoteLink>
<a href="/adicionarBanda/index">Cadastrar Bandas</a>
<a href="/adicionaData/index">Cadastrar data do Show</a>

<div id="divLista">
    <g:render template="lista" model="[locais: locais]"></g:render>
</div>


<div id="divForm"></div>
</body>
</html>
