import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerEnrollmentsComponent } from './trainer-enrollments.component';

describe('TrainerEnrollmentsComponent', () => {
  let component: TrainerEnrollmentsComponent;
  let fixture: ComponentFixture<TrainerEnrollmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TrainerEnrollmentsComponent]
    });
    fixture = TestBed.createComponent(TrainerEnrollmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
