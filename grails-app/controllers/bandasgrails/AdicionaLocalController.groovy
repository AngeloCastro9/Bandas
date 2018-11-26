package bandasgrails

class AdicionaLocalController {

    def index() {
        def lista = Local.list()

        render(view:"/adicionaLocal/index", model: [locais: lista])
    }

    def adicionar(){
        Local novoLocal = new Local()
        novoLocal.nome = params.nome
        novoLocal.capacidade = 0
        render(template: "/adicionaLocal/form", model: [locais:novoLocal])

    }
    def salvar(){
        Local local = null
        if(params.id)
        {
            local = Local.get(params.id)
        }else{
            local = new Local()
        }

        local.nome = params.nome
        local.capacidade = 0
        if(!local.hasErrors()){
            local.save(flush:true)
            render("Salvou com sucesso")
        } else {
            render("Não salvoou")
        }

    }
    def alterar(){
        Local local = Banda.get(params.id)
        render(template:"/adicionaLocal/form", model:[locais: local])
    }
    def excluir(){
        Local local = Local.get(params.id)
        local.delete(flush:true)
        def lista = Local.list()
        render(template: "/adicionaLocal/lista", model: [locais: lista])
    }
}
