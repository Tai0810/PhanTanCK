package services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entities.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class DepartmentService {

    private EntityManager entityManager;

    public DepartmentService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Map<Department, Long> countCoursesByDepartment() {
        Map<Department, Long> map = new LinkedHashMap<>();

        // Kiểm tra xem truy vấn có tồn tại không
        Query query = entityManager.createNamedQuery("Department.countCoursesByDepartment");
        if (query == null) {
            System.err.println("NamedQuery 'Department.countCoursesByDepartment' not found.");
            return map;
        }

        // Thực thi truy vấn và xử lý kết quả
        List<?> results = query.getResultList();
        results.forEach(result -> {
            if (result instanceof Object[]) {
                Object[] row = (Object[]) result;
                if (row.length >= 2 && row[0] instanceof Department && row[1] instanceof Long) {
                    Department department = (Department) row[0];
                    Long count = (Long) row[1];
                    map.put(department, count);
                } else {
                    System.err.println("Invalid result row format: " + result);
                }
            } else {
                System.err.println("Invalid result format: " + result);
            }
        });

        return map;
    }
}
