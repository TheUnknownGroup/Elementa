use std::sync::Arc;
use winit::{
    application::ApplicationHandler, 
    dpi::PhysicalSize, 
    event::{KeyEvent, WindowEvent}, 
    event_loop::{ActiveEventLoop, ControlFlow, EventLoop}, 
    keyboard::{KeyCode, PhysicalKey}, 
    window::{Window, WindowId}
};

pub struct State {
    window: Arc<Window>,
    size: PhysicalSize<u32>,
}

impl State {
    fn new(window: Arc<Window>) -> Self {
        let size = window.inner_size();
        Self { window, size }
    }

    fn resize(&mut self, size: PhysicalSize<u32>) {
        self.size = size;
    }

    fn render(&mut self) {
        let _size = self.size;
    }
}

#[derive(Default)]
pub struct App {
    state: Option<State>,
}

impl ApplicationHandler for App {
    fn resumed(&mut self, event_loop: &ActiveEventLoop) {
        if self.state.is_some() { return }
        let attributes = Window::default_attributes().with_title("Elementa").with_min_inner_size(PhysicalSize::new(1280, 720)).with_inner_size(PhysicalSize::new(1280, 720));
        let window = match event_loop.create_window(attributes) {
            Ok(window) => Arc::new(window),
            Err(error) => {
                log::error!("Failed to create Elementa window: {error}");
                event_loop.exit();
                return;
            }
        };

        self.state = Some(State::new(Arc::clone(&window)));
        window.request_redraw();
    }

    fn window_event(&mut self, event_loop: &ActiveEventLoop, window_id: WindowId, event: WindowEvent) {
        let Some(state) = self.state.as_mut() else { return };
        if state.window.id() != window_id { return }

        match event {
            WindowEvent::CloseRequested => event_loop.exit(),
            WindowEvent::Resized(size) => state.resize(size),
            WindowEvent::RedrawRequested => state.render(),
            WindowEvent::KeyboardInput { event: KeyEvent { physical_key: PhysicalKey::Code(KeyCode::Escape), state: key_state, .. }, .. } if key_state.is_pressed() => event_loop.exit(),
            _ => {}
        }
    }
}

pub fn run() -> anyhow::Result<()> {
    env_logger::init();
    let event_loop = EventLoop::new()?;
    event_loop.set_control_flow(ControlFlow::Wait);
    let mut app = App::default();
    event_loop.run_app(&mut app)?;

    Ok(())
}
