package pro.sky.expenses.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.sky.expenses.application.entity.Expense;
import pro.sky.expenses.application.entity.ExpenseByCategory;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    @Query(value = "SELECT category, SUM(amount) as amount FROM expenses GROUP BY category", nativeQuery = true)
    List<ExpenseByCategory> getExpensesByCategory();

}
