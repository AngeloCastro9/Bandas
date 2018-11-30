<%@ page import="bandasgrails.Banda; learning_grails.BandaEnum" %>
<div id="divMenssagem"></div>
<g:formRemote name="frmProduto" url="[controller: 'adicionaData', action: 'salvar']" update="divMenssagem" onSuccess="carregarLista()">
    <g:select name="bandas" from="${bandasgrails.Banda.list()}" optionKey="id" value="${shows.banda}"
              noSelection="['':'Selecione uma banda']"
              multiple="true"
    />

    <g:message code="adicionarBanda.dataDoShow.message"/>
    <input type="text" name="data" value="${shows.data as java.util.Date}" /> <br/>
    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" id="123" value="Cancelar" onclick="cancelar()"/>
    <input type="hidden" name="id" value="${shows.id}" />
</g:formRemote>