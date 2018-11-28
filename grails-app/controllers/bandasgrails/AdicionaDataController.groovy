package bandasgrails



class AdicionaDataController {

        def index() {
            def lista = Show.list()

            render(view:"/adicionaData/index", model: [shows: lista])
        }

        def adicionar(){
            Show show = new Show()
            show.data = params.data
            render(template: "/adicionaData/form", model: [shows: show])

        }
    def salvar(){
        Show show = null
        if(params.id)
        {
            show = Show.get(params.id)


        }else{
            show = new Show()
        }

        //show.data = params.data as Date
        //new Date().parse('dd/MM/yyyy', show)
        java.util.Date dt = new java.util.Date();
        java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

        String currentTime = sdf.format(dt);
        show.setData(sdf.parse( request.getParameter("data")));
        println(params)
        if(show.save(flush:true)){

            render("Salvou com sucesso")
        } else {
            println(show.errors)
            render("Não salvou")
        }

    }
        def alterar(){
            Show show = Show.get(params.id)
            render(template:"/adicionaData/form", model:[shows: show])
        }
        def excluir(){
            Show show = Show.get(params.id)
            show.delete(flush:true)
            def lista = Show.list()
            render(template: "/adicionaData/lista", model: [shows: show])
        }
        def irParaBandas(){
            render(template: "/adicionarBanda/lista", model: [shows:show])
        }

    }
