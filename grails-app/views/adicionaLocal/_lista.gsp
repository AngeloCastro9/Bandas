<g:if test="${locais.size()> 0}">
    <table>
        <tr>
            <th><g:message code="adicionarBanda.nomeDaBanda.message" /></th>
            <th><g:message code="adicionarBanda.generoDaBanda.message" /></th>


        </tr>
        <g:each var="local" in="${locais}">
            <tr>
                <td>${local.nome}</td>
                <td>${local.capacidade}</td>

                <td>
                    <g:remoteLink controller="adicionaLocal" action="alterar" update="divForm" id="${local.id}">Alterar</g:remoteLink>

                    <a href="#" onclick="excluir('${local.id}')">Excluir</a>
                </td>

            </tr>
        </g:each>
    </table>
</g:if>
<g:else>
    <g:message code="adicionarBanda.faltaDeBandas.message" />
</g:else>