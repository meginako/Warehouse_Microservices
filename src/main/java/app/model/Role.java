package app.model;

import app.enums.ERole;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "roles")
public class Role {
  @Id
  private String id;

  private ERole name;

  public Role() {

  }

  public Role(ERole name) {
    this.name = name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(ERole name) {
    this.name = name;
  }
}
