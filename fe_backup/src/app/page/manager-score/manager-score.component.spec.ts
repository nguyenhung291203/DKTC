import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerScoreComponent } from './manager-score.component';

describe('ManagerScoreComponent', () => {
  let component: ManagerScoreComponent;
  let fixture: ComponentFixture<ManagerScoreComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManagerScoreComponent]
    });
    fixture = TestBed.createComponent(ManagerScoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
