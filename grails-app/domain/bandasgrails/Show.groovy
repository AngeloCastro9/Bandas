package bandasgrails

import grails.databinding.BindingFormat

class Show {
    @BindingFormat('yyyyMMdd')
    Date data

    static mapping = {
        table 'shows'
    }

    static hasMany = [banda:Banda]
    static belongsTo = Local
    static constraints = {

    }
}
