package bandasgrails



class AdicionaDataController {

    def index() {
        def lista = Show.list()
        def lista1 = Banda.list()
        render(view:"/adicionaData/index", model: [shows: lista, bandas: lista1])
    }


//    def index() {
//        def lista = Show.list()
//        def bandaList = Banda.findAll([sort:"nome", order:"asc"])
//        render(view:"/adicionaData/index", model:[shows: lista ,bandaList:bandaList])
//        return
//    }

    def adicionar(){
        Show show = new Show()
        Banda bandas = new Banda()
        show.data = params.data
        bandas.id = params.id
        bandas.nome = params.nome

        render(template: "/adicionaData/form", model: [shows: show, bandas: bandas])

    }
    def salvar(){
        Show show = null
        Banda banda = null
        if(params.id)
        {
            show = Show.get(params.id)
            show.banda = Banda.get(params.id)

            params.bandas.each {
               Banda bandas = Banda.get(it)
               show.removeFromBanda(bandas)
               println(params.bandas)
           }
            show.delete()
        }else{
            show = new Show()
        }
        java.util.Date dt = new java.util.Date()
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd")

        String currentTime = sdf.format(dt)
        show.setData(sdf.parse( request.getParameter("data")))

        params.bandas.each {
            Banda banda1 = Banda.get(it)
            show.addToBanda(banda1)
            println(params.bandas)
            show.save(flush:true)
        }

        if(show.save(flush:true)){

            render("Salvou com sucesso")
        } else {
            println(show.errors)
            render("Não salvou")
        }

    }
    def alterar(){
        Show show = Show.get(params.id)
        Banda banda = Banda.get(params.bandas)
        Banda.get(params.id)
        render(template:"/adicionaData/form", model:[shows: show, bandas: banda])
    }
    def excluir(){
        Show show = Show.get(params.id)
        params.bandas.each {
            Banda bandas = Banda.get(it)
            show.removeFrom(bandas)
            println(params.bandas)
        }
        show.delete(flush:true)
        def lista = Show.list()
        render(template: "/adicionaData/lista", model: [shows: lista])
    }

}
