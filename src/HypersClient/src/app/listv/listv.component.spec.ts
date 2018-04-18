import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListvComponent } from './listv.component';

describe('ListvComponent', () => {
  let component: ListvComponent;
  let fixture: ComponentFixture<ListvComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListvComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
