<g:if test="${shows.size()> 0}">
    <table>
        <tr>
            <th><g:message code="adicionarBanda.nomeDaBanda.message" /></th>
            <th><g:message code="adicionarBanda.generoDaBanda.message" /></th>


        </tr>
        <g:each var="show" in="${shows}">
            <tr>
                <td><g:formatDate format="dd-MM-yyyy" date="${show.data}"/></td>
                <td>
                    <g:remoteLink controller="adicionaData" action="alterar" update="divForm" id="${show.id}">Alterar</g:remoteLink>

                    <a href="#" onclick="excluir('${show.id}')">Excluir</a>
                </td>

            </tr>
        </g:each>

    </table>
</g:if>
<g:else>
    <g:message code="adicionarBanda.faltaDeDatas.message" />
</g:else>