package pro.sky.expenses.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.expenses.application.entity.ExpenseByCategory;
import pro.sky.expenses.application.service.ExpenseService;

import java.util.List;

@RestController
public class ExpensesByCategoryController {

    private final ExpenseService expenseService;

    public ExpensesByCategoryController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses-by-categories")
    public List<ExpenseByCategory> getExpensesByCategories() {
        return expenseService.getExpenseByCategory();
    }
}
