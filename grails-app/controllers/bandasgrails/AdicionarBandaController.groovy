package bandasgrails

class AdicionarBandaController {

    def index() {
        def lista = Banda.list()

        render(view:"/adicionarBanda/index", model: [bandas:lista])
    }

    def adicionar(){
        Banda novaBanda = new Banda()
        novaBanda.nome = params.nome
        novaBanda.bandaEnum
        render(template: "/adicionarBanda/form", model: [bandas:novaBanda])

    }
    def salvar(){
        Banda banda = null
        BandaEnum bandaEnum = null
        if(params.id)
        {
            banda = Banda.get(params.id)


        }else{
            banda = new Banda()
        }

        banda.nome = params.nome
        banda.bandaEnum = params.banda_enum
        println(params)
        if(banda.save(flush:true)){

            render("Salvou com sucesso")
        } else {
            println(banda.errors)
            render("Não salvou")
        }

    }
    def alterar(){
        Banda banda = Banda.get(params.id)
        render(template:"/adicionarBanda/form", model:[bandas: banda])
    }
    def excluir(){
        Banda banda = Banda.get(params.id)
        banda.delete(flush:true)
        def lista = Banda.list()
        render(template: "/adicionarBanda/lista", model: [bandas: lista])
    }


}
