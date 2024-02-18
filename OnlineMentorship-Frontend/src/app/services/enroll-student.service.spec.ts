import { TestBed } from '@angular/core/testing';

import { EnrollStudentService } from './enroll-student.service';

describe('EnrollStudentService', () => {
  let service: EnrollStudentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnrollStudentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
