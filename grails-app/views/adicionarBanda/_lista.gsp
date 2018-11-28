<g:if test="${bandas.size()> 0}">
    <table>
        <tr>
            <th><g:message code="adicionarBanda.nomeDaBanda.message" /></th>
            <th><g:message code="adicionarBanda.generoDaBanda.message" /></th>


        </tr>
        <g:each var="banda" in="${bandas}">
            <tr>
                <td>${banda.nome}</td>
                <td>${banda.bandaEnum.value}</td>

                <td>
                    <g:remoteLink controller="adicionarBanda" action="alterar" update="divForm" id="${banda.id}">Alterar</g:remoteLink>

                    <a href="#" onclick="excluir('${banda.id}')">Excluir</a>
                </td>

            </tr>
        </g:each>
    </table>
</g:if>
<g:else>
    <g:message code="adicionarBanda.faltaDeBandas.message" />
</g:else>