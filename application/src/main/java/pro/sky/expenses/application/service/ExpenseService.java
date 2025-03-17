package pro.sky.expenses.application.service;

import org.springframework.stereotype.Service;
import pro.sky.expenses.application.entity.Expense;
import pro.sky.expenses.application.entity.ExpenseByCategory;
import pro.sky.expenses.application.repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void createExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }

    public List<ExpenseByCategory> getExpenseByCategory() {
        return expenseRepository.getExpensesByCategory();
    }
}
