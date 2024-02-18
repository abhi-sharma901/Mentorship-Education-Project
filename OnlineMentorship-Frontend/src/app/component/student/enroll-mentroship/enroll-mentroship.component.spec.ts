import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrollMentroshipComponent } from './enroll-mentroship.component';

describe('EnrollMentroshipComponent', () => {
  let component: EnrollMentroshipComponent;
  let fixture: ComponentFixture<EnrollMentroshipComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EnrollMentroshipComponent]
    });
    fixture = TestBed.createComponent(EnrollMentroshipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
