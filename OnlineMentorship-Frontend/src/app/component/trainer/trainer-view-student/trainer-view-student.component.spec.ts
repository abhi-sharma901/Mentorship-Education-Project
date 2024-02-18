import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerViewStudentComponent } from './trainer-view-student.component';

describe('TrainerViewStudentComponent', () => {
  let component: TrainerViewStudentComponent;
  let fixture: ComponentFixture<TrainerViewStudentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TrainerViewStudentComponent]
    });
    fixture = TestBed.createComponent(TrainerViewStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
