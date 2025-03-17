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
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @PostMapping
    public ResponseEntity<?> createExpense(@RequestBody Expense expense) {
        try {
            if (expense == null) {
                return ResponseEntity.badRequest().body("Expense cannot be null");
            }

            expenseService.createExpense(expense);
            return ResponseEntity.ok("Expense created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(null);
    }
}
