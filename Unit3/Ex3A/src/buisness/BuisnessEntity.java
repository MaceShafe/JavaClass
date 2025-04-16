package buisness;

import java.time.LocalDateTime;

public class BuisnessEntity  {
    public int Id;
    private LocalDateTime creationDate;

    public BuisnessEntity() {}


    public BuisnessEntity(int id, LocalDateTime creationDate) {
    }


    public int getId() {
        return Id;
    }

    public int setId(int id) {
        Id = id;
        return Id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate() {
        this.creationDate = LocalDateTime.now();
    }
}
