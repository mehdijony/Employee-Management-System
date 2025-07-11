import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employeeId: string;
  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.employeeId = this.route.snapshot.params['employeeId'];

    this.employeeService.getEmployeeById(this.employeeId).subscribe(data => {
      this.employee = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.employeeService.updateEmployee(this.employeeId, this.employee).subscribe(data => {
      this.toastr.success('Employee Updated Successfully!', 'Success!');
      this.goToEmployeeList();
    }
      , error => {
        this.toastr.error(error.error.message, 'Error!');
        console.log(error);
      }
      );
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }


}
