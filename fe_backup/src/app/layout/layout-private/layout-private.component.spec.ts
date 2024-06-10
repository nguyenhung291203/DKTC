import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutPrivateComponent } from './layout-private.component';

describe('LayoutPrivateComponent', () => {
  let component: LayoutPrivateComponent;
  let fixture: ComponentFixture<LayoutPrivateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LayoutPrivateComponent]
    });
    fixture = TestBed.createComponent(LayoutPrivateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
