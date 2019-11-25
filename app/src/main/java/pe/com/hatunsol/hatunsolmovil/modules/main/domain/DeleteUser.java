package pe.com.hatunsol.hatunsolmovil.modules.main.domain;

import pe.com.hatunsol.hatunsolmovil.modules.main.data.source.MainRepository;

public class DeleteUser {
    private MainRepository repository;

    public DeleteUser(MainRepository repository) {
        this.repository = repository;
    }

    public Response execute(){
        return new Response(repository.DeleteUser());
    }

    public static class Response{
        private Boolean value;

        public Response(Boolean value) {
            this.value = value;
        }

        public Boolean deleteUsuario() {
            return value;
        }
    }
}
