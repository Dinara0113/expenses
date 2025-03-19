package pro.sky.expenses.application.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.expenses.application.entity.Expense;
import pro.sky.expenses.application.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestParam("page") Integer pageNumber, @RequestParam("size") Integer pageSize) {
        List<Expense> expenses = expenseService.getAllExpenses(pageNumber, pageSize);
        return ResponseEntity.ok(expenses);
    }

    @PostMapping
    public ResponseEntity<?> createExpense(@RequestBody Expense expense) {
        expenseService.createExpense(expense);
        return ResponseEntity.ok(null);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(null);
    }
}
