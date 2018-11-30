<%@ page import="learning_grails.BandaEnum" %>
<div id="divMenssagem"></div>

<g:formRemote name="frmProduto" url="[controller: 'adicionarBanda', action: 'salvar']" update="divMenssagem" onSuccess="carregarLista()">
    <g:message code="adicionarBanda.nomeDaBanda1.message"/> <input type="text" name="nome" value="${bandas.nome}" /> <br/>
    <g:message code="adicionarBanda.generoDaBanda1.message"/>

    <g:select name="banda_enum" id="id" from="${BandaEnum.values()}"/>


    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" id="123" value="Cancelar" onclick="cancelar()"/>
    <input type="hidden" name="id" value="${bandas.id}" />
</g:formRemote>