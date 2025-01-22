import { PropsWithChildren } from "react";

export default function IndexLayout({ children }: PropsWithChildren) {
  return <div className="prose max-w-none">{children}</div>;
}
