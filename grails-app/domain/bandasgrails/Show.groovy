package bandasgrails

class Show {
    Date data

    static hasMany = [banda:Banda]
    static belongsTo = [local:Local]
    static constraints = {
    }
}
