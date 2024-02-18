import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMentorshipComponent } from './create-mentorship.component';

describe('CreateMentorshipComponent', () => {
  let component: CreateMentorshipComponent;
  let fixture: ComponentFixture<CreateMentorshipComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateMentorshipComponent]
    });
    fixture = TestBed.createComponent(CreateMentorshipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
