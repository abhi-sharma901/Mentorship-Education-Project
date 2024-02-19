import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTrainersComponent } from './view-trainers.component';

describe('ViewTrainersComponent', () => {
  let component: ViewTrainersComponent;
  let fixture: ComponentFixture<ViewTrainersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewTrainersComponent]
    });
    fixture = TestBed.createComponent(ViewTrainersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
