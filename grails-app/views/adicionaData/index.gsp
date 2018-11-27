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
            //Em vez de usar um Jquery, deve-se usar um $
            $("#divForm").html("")
        }
    </script>
</head>
<body>
<g:remoteLink controller="adicionaData" action="adicionar" update="divForm">Adicionar</g:remoteLink>


<div id="divLista">
    <g:render template="lista" model="[shows: shows]"></g:render>
</div>


<div id="divForm"></div>
</body>
</html>
