import { PropsWithChildren } from "react";

export default function BaseLayout({ children }: PropsWithChildren) {
  return (
    <div className="mx-auto min-h-screen max-w-6xl bg-white px-2">
      {children}
    </div>
  );
}
