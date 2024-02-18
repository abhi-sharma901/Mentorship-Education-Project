import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAssignMentorshipComponent } from './admin-assign-mentorship.component';

describe('AdminAssignMentorshipComponent', () => {
  let component: AdminAssignMentorshipComponent;
  let fixture: ComponentFixture<AdminAssignMentorshipComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminAssignMentorshipComponent]
    });
    fixture = TestBed.createComponent(AdminAssignMentorshipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
