package bandasgrails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LocalController {

    LocalService localService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond localService.list(params), model:[localCount: localService.count()]
    }

    def show(Long id) {
        respond localService.get(id)
    }

    def create() {
        respond new Local(params)
    }

    def save(Local local) {
        if (local == null) {
            notFound()
            return
        }

        try {
            localService.save(local)
        } catch (ValidationException e) {
            respond local.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'local.label', default: 'Local'), local.id])
                redirect local
            }
            '*' { respond local, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond localService.get(id)
    }

    def update(Local local) {
        if (local == null) {
            notFound()
            return
        }

        try {
            localService.save(local)
        } catch (ValidationException e) {
            respond local.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'local.label', default: 'Local'), local.id])
                redirect local
            }
            '*'{ respond local, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        localService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'local.label', default: 'Local'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'local.label', default: 'Local'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
