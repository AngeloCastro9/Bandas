<%@ page import="bandasgrails.BandaEnum" %>
<div id="divMenssagem"></div>
<g:formRemote name="frmProduto" url="[controller: 'adicionarBanda', action: 'salvar']" update="divMenssagem" onSuccess="carregarLista()">
    Nome da Banda <input type="text" name="nome" value="${bandas.nome}" /> <br/>
    Genero da Banda
    <g:radioGroup name="BandaEnum"
                  labels="['Rock','Forró','Axé']"
                  values="[1,2,3]">
        <p>${it.label} ${it.radio}</p>
    </g:radioGroup>
    %{--<g:select name="banda" from="${BandaEnum.values()}" optionKey="key" />--}%
    %{--<g:select name="forro" from="${bandasgrails.BandaEnum.values()}" value="${bandas?.generos?.key}"/>--}%
    <input type="submit" name="btnSalvar" value="Salvar" />
    <input type="button" name="btnCancelar" id="123" value="Cancelar" onclick="cancelar()"/>
    <input type="hidden" name="id" value="${bandas.id}" />
</g:formRemote>