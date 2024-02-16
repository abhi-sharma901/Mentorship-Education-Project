import { TestBed } from '@angular/core/testing';

import { MentorshipsService } from './mentorships.service';

describe('MentorshipsService', () => {
  let service: MentorshipsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MentorshipsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
