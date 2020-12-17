package main.java.ch.spring;

@Repository
public class ExampleRepository extends JpaRepository<ExampleDbo, UUID> {
    
    ExampleDbo findByExampleId();
    
    List<ExampleDbo> findByExampleStatus(String exampleStatus);
    
    Long countByExampleStatus(String exampleStatus);
    
    @Query(value = "SELECT count(id) from dbschema.t_example", nativeQuery = true)
    Long countAllExample();
   
    @Query("select example from ExampleDbo example inner join example.exampleDetailDbo detail where detail.text = ?1")
    List<ExampleDbo> findByExampleDetailText(String exampleDetailText); 

}
