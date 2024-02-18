import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAssignCourseComponent } from './admin-assign-course.component';

describe('AdminAssignCourseComponent', () => {
  let component: AdminAssignCourseComponent;
  let fixture: ComponentFixture<AdminAssignCourseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminAssignCourseComponent]
    });
    fixture = TestBed.createComponent(AdminAssignCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
