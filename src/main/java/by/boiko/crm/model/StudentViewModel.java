package by.boiko.crm.model;

public class StudentViewModel {

    private Integer id;
    private String fullName;
    private Integer numberGroup;
    private Integer idGroup;

    public StudentViewModel(Integer id, String fullName, Integer numberGroup, Integer idGroup) {
        this.id = id;
        this.fullName = fullName;
        this.numberGroup = numberGroup;
        this.idGroup = idGroup;
    }

    public StudentViewModel() {

    }

    public String getFullName() {
        return fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(Integer numberGroup) {
        this.numberGroup = numberGroup;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }
}
