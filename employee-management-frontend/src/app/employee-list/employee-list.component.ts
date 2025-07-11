import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];
  constructor(private employeeService: EmployeeService, private router: Router, private toastr: ToastrService ) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });
    console.log(this.employees);
  }


  employeeDetails(employeeId: string) {
    this.router.navigate(['employee-details', employeeId]);
  }

  updateEmployee(employeeId: string) {
    this.router.navigate(['update-employee', employeeId]);
  }

  deleteEmployee(employeeId: string) {
    this.employeeService.deleteEmployee(employeeId).subscribe(data => {
      console.log(data);
      this.toastr.success('Employee Deleted Successfully!', 'Success!');
      this.getEmployees();
    })
  }




}
